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


;Exercise 1.1
10
;

(+ 5 3 4)
;12

(- 9 1)
;8

(/ 6 2)
;3

(+ (* 2 4) (- 4 6))
;6

(def a 3)
;#'sicp/a

(def b (+ a 1))
;#'sicp/b

(+ a b (* a b))
;19

(= a b)
;false

(if (and (> b a) (< b (* a b)))
    b
    a)
;4

(cond (= a 4) 6
      (= b 4) (+ 6 7 a)
      :else 25)
;16

(+ 2 (if (> b a) b a))
;6

(+ (cond (> a b) a
         (< a b) b
         :else -1))
;4

;Exercise 1.2
(/ (+ 5
      4
      (- 2
         (- 3
            (+ 6
               (/ 4 5)))))
   (* 3
      (- 6 2)
      (- 2 7)))
;-37/150

;Exercise 1.3. Define a procedure that takes three numbers as arguments and returns the sum of the squares of the two larger numbers.
(defn sum-of-squares-two-larger-numbers [x y z]
  (cond (or (<= z y x) (<= z x y)) (sum-of-squares x y)
        (or (<= x z y) (<= x y z)) (sum-of-squares y z)
        (or (<= y x z) (<= y z x)) (sum-of-squares z x)))

(= (sum-of-squares-two-larger-numbers 1 1 1) (sum-of-squares 1 1))
(= (sum-of-squares-two-larger-numbers 1 1 2) (sum-of-squares 1 2))
(= (sum-of-squares-two-larger-numbers 1 2 3) (sum-of-squares 2 3))
(= (sum-of-squares-two-larger-numbers 1 3 2) (sum-of-squares 2 3))
(= (sum-of-squares-two-larger-numbers 3 2 1) (sum-of-squares 2 3))
(= (sum-of-squares-two-larger-numbers 2 1 3) (sum-of-squares 2 3))

;Exercise 1.4
;special form, special symbol과 procedure의 차이는 무엇인가?
;왜 and, or는 special form이고, not은 procedure인가?
;combination엮은식이라 부르는이유? expression표현식이랑 다른가? 같다. 표현이 다를뿐
;compound expression => primitive symbol을 여러번 사용하여 나타내는 복잡한식은?
(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))
;applicative-order evaluation(인자먼저계산법)

(a-plus-abs-b 3 -1)   ;4
(a-plus-abs-b 999 -1) ;1000
(a-plus-abs-b 0 1)    ;1

;Exercise 1.5
(defn p [] (p))

(defn test [x y]
  (if (= x 0)
      0
      y))

(test 3 3)   ;3
(test 0 (p)) ;StackOverflowError
;Clojure는 applicative-order evaluation을 하기 때문에 y->(p)에서 끝없이 반복된다.
;normal-order evaluation일 경우 y를 (p)로 둔 상태에서 (= x 0) 조건에 걸려 계산이 끝난다.

;1.1.7
;Newton method
;x의 제곱근에 가까운 값 y가 있을 때 y와 x/y의 평균을 구하여 진짜 제곱근에 더 가까운 값을 구하는 방법
(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
      guess
      (sqrt-iter (improve guess x)
                 x)))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn average [x y]
  (/ (+ x y) 2))

