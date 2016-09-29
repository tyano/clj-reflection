(ns clj-reflection.core-test
  (:require [clojure.test :refer :all]
            [clj-reflection.core :refer :all]))

(deftest tests-for-accessible
  (let [inner (Double. 100.0)
        obj   (accessible inner)]
    (testing "Can access to a private field."
      (is (= (:SIZE obj) 64))
      (is (= (:value obj) 100.0)))

    (testing "return a default value if a target field doesn't exist."
      (is (= (get obj :SIZE2 -1) -1)))

    (testing "return a Double by calling 'object'"
      (is (= (class (object obj)) java.lang.Double))
      (is (identical? (object obj) inner)))))
