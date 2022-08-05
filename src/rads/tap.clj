(ns rads.tap)

(def ^:private ratom
  (if (System/getProperty "babashka.version")
    atom
    (requiring-resolve 'freactive.core/atom)))

(defonce ^:private config (ratom {:limit 100}))

(defonce log (ratom []))

(defn- ->log
  ([] [])
  ([v] (vec (take-last (:limit @config) v)))
  ([v x] (->log (conj v x))))

(defn- tap-fn [x]
  (swap! log ->log x))

(defn clear []
  (reset! log (->log)))

(defn limit [n]
  (swap! config assoc :limit n)
  (swap! log ->log)
  nil)

(add-tap tap-fn)
