(ns sicp)
;nil

;1.1.1
486
;

(+ 137 349)
;486

(- 1000 334)
;666

(* 5 99)
;495

(/ 10 5)
;2

(+ 2.7 10)
;12.7

(+ 21 35 12 7)
;75

(* 25 4 12)
;1200

(+ (* 3 5) (- 10 6))
;19

(+ (* 3 (+ (* 2 4) (+ 3 5))) (+ (- 10 7) 6))
;57

(+ (* 3
      (+ (* 2 4)
         (+ 3 5)))
   (+ (- 10 7)
      6))
;57


;1.1.2
(def size 2)
;#'sicp/size

size
;2

(* 5 size)
;10

(def pi 3.14159)
;#'sicp/pi

(def radius 10)
;#'sicp/radius

(* pi (* radius radius))
;314.159

(def circumference (* 2 pi radius))
;#'sicp/circumference

circumference
;62.8318


;1.1.3
(* (+ 2 (* 4 6))
   (+ 3 5 7))
;390

;1.1.4
(defn square [x]
  (* x x))
;#'sicp/square

(square 21)
;441

(square (+ 2 5))
;49

(square (square 3))
;81

(+ (square x) (square y))
; x^2 + y^2

(defn sum-of-squares [x y]
  (+ (square x) (square y)))
;#'sicp/sum-of-squares

(sum-of-squares 3 4)
;25

(defn f [a]
  (sum-of-squares (+ a 1) (* a 2)))
;#'sicp/f

(f 5)
;136

;1.1.5
;substitution model
(f 5)
;136

(sum-of-squares (+ a 1) (* a 2))
;Unable to resolve symbol

(sum-of-squares (+ 5 1) (* 5 2))
;136

(+ (square 6) (square 10))
;136

(+ (* 6 6) (* 10 10))
;136

(+ 36 100)
;136

136
;

;normal-order evaluation
(f 5)
;136

(sum-of-squares (+ 5 1) (* 5 2))
;136

(+ (square (+ 5 1)) (square (* 5 2)))
;136

(+ (* (+ 5 1) (+ 5 1)) (* (* 5 2) (* 5 2)))
;136

(+ (* 6 6) (* 10 10))
;136

(+ 36 100)
;136

;1.1.6
(defn abs [x]
  (cond (> x 0) x
        (= x 0) 0
        (< x 0) (- x)))
;#'sicp/abs

(defn abs [x]
  (cond (< x 0) (- x)
        :else x))
;#'sicp/abs

(defn abs [x]
  (if (< x 0)
      (- x)
      x))
;#'sicp/abs

(and (> x 5) (< x 10))
;5<x<10

(defn >= [x y]
  (or (> x y) (= x y)))
;#'sicp/>=

(defn >= [x y]
  (not (< x y)))
;#'sicp/>=
