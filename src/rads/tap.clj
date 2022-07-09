(ns rads.tap)

(defonce log (atom []))
(defonce limit (atom 100))

(defn- add-to-log [x]
  (swap! log
         #(->> (conj %1 %2)
               (take-last @limit)
               (vec))
         x))

(defn clear []
  (reset! log []))

(add-tap add-to-log)
