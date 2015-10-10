(ns hierarchical-storage.core
  (:gen-class)
  (:require [clojure.java.io :as io])
  (:import (java.util Map List Collection)
           (org.analyticbastard.hierarchicalstorage IHierarchicalStorage)))

(defn combine [& maps]
  (apply merge-with combine (filter map? maps)))

(defn store
  ([mem-store key-or-keys value]
   (if (instance? Collection key-or-keys)
     (swap! mem-store assoc-in key-or-keys value)
     (swap! mem-store assoc key-or-keys value)))
  ([mem-store all]
   (swap! mem-store combine all))
  )

(defn create-hierarchical-storage [filename]
  (if-not (.exists (io/as-file filename))
    (spit filename {})
    (when-not (map? (read-string (slurp filename)))
      (spit filename {})))
  (let [mem-store (atom (read-string (slurp filename)))]
    (reify IHierarchicalStorage
      (^void store [_ ^Collection coll ^String value]
        (store mem-store coll value)
        (spit filename @mem-store))
      (^void store [_ ^Map all]
        (store mem-store all)
        (spit filename @mem-store))
      (^void store [_ ^String key ^String value]
        (store mem-store (list key) value)
        (spit filename @mem-store))
      (^String recall [_ ^Collection coll]
        (get-in @mem-store coll))
      )))