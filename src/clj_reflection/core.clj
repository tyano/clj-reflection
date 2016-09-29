(ns clj-reflection.core
  (:import [clojure.lang ILookup]))

(defn- read-field-value
  [^Class type field-name instance]
  (try
    (let [field (.getDeclaredField type field-name)]
      (when field
        (.setAccessible field true)
        (.get field instance)))
    (catch NoSuchFieldException ex nil)))

(defprotocol IContainer
  (object [_] "return a object this container is holding."))

(defn accessible
  [obj]
  (when obj
    (reify
      clojure.lang.ILookup
      (valAt [_ key]
        (read-field-value (class obj) (name key) obj))

      (valAt [this key not-found]
        (or (.valAt ^ILookup this key) not-found))

      IContainer
      (object [_] obj))))


