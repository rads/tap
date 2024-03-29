(ns build
  (:require [clojure.tools.build.api :as b]
            [org.corfield.build :as bb]))

(def lib 'io.github.rads/tap)
(def version "0.2.0")

(defn ci
  "Run the CI pipeline of tests (and build the JAR)." [opts]
  (-> opts
      (assoc :lib lib :version version)
      (bb/clean)
      (bb/jar)))

(defn install
  "Install the JAR locally."
  [opts]
  (-> opts
      (assoc :lib lib :version version)
      (bb/install)))

(defn deploy
  "Deploy the JAR to Clojars."
  [opts]
  (-> opts
      (assoc :lib lib :version version)
      (bb/deploy)))
