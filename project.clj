(defproject analyticbastard/hierarchical-storage "0.1.0-SNAPSHOT"
  :description "Tree storage of string values under hierarchical key paths"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths ["src/clj"]
  :java-source-paths ["src/java"]
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
