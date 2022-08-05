(ns rads.tap)

(def ratom
  (if (System/getenv "babashka.version")
    atom
    (requiring-resolve 'freactive.core/atom)))

(defonce log (ratom []))
(defonce limit (ratom 100))

(defn- add-to-log [x]
  (swap! log
         #(->> (conj %1 %2)
               (take-last @limit)
               (vec))
         x))

(defn clear []
  (reset! log []))

(add-tap add-to-log)
