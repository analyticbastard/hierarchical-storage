(ns hierarchical-storage.core-test
  (:require [clojure.test :refer :all]
            [hierarchical-storage.core :refer :all])
  (:import (java.io File)))

(deftest test-simple-storage
  (testing "Simple key storage"
    (let [storage (create-hierarchical-storage (str (System/getProperty "java.io.tmpdir")
                                                    File/separator "simple-key-storage.edn"))
          ]
      (.store storage "key" "value")
      (is (= (.recall storage ["key"]) "value")))))


(comment
  (clojure.test/run-tests 'hierarchical-storage.core-test)
  )