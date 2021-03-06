(def scanlines [
;  PF0---- PF1------------ PF2------------ PF0---- PF1------------ PF2------------
  [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
  [0 1 1 1 0 0 0 1 1 1 0 0 1 1 1 1 0 1 0 0 0 1 0 0 1 1 1 1 0 1 1 1 1 0 0 0 1 1 1 0]
  [1 0 0 0 1 0 1 0 0 0 1 0 1 0 0 0 0 1 1 0 0 1 0 1 0 0 0 0 0 1 0 0 0 1 0 1 0 0 0 1]
  [1 0 0 0 1 0 1 0 0 0 1 0 1 0 0 0 0 1 1 0 0 1 0 1 0 0 0 0 0 1 0 0 0 1 0 1 0 0 0 0]
  [1 0 0 0 1 0 1 0 0 0 1 0 1 0 0 0 0 1 0 1 0 1 0 1 0 0 0 0 0 1 0 0 0 1 0 1 0 0 0 0]
  [1 0 0 0 1 0 1 1 1 1 0 0 1 1 1 0 0 1 0 1 0 1 0 0 1 1 1 0 0 1 1 1 1 0 0 1 0 0 0 0]
  [1 0 0 0 1 0 1 0 0 0 0 0 1 0 0 0 0 1 0 1 0 1 0 0 0 0 0 1 0 1 0 1 0 0 0 1 0 0 0 0]
  [1 0 0 0 1 0 1 0 0 0 0 0 1 0 0 0 0 1 0 0 1 1 0 0 0 0 0 1 0 1 0 0 1 0 0 1 0 0 0 0]
  [1 0 0 0 1 0 1 0 0 0 0 0 1 0 0 0 0 1 0 0 1 1 0 0 0 0 0 1 0 1 0 0 1 0 0 1 0 0 0 1]
  [0 1 1 1 0 0 1 0 0 0 0 0 1 1 1 1 0 1 0 0 0 1 0 1 1 1 1 0 0 1 0 0 0 1 0 0 1 1 1 0]
  [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
  [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
  [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
  [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
  [0 1 1 1 0 0 0 1 1 1 0 0 1 1 1 1 0 1 0 0 0 1 0 1 0 0 0 1 0 1 1 1 1 1 0 0 1 1 1 0]
  [1 0 0 0 1 0 1 0 0 0 1 0 1 0 0 0 0 1 1 0 0 1 0 1 1 0 1 1 0 0 0 1 0 0 0 1 0 0 0 1]
  [1 0 0 0 1 0 1 0 0 0 1 0 1 0 0 0 0 1 1 0 0 1 0 1 1 0 1 1 0 0 0 1 0 0 0 1 0 0 0 0]
  [1 0 0 0 1 0 1 0 0 0 1 0 1 0 0 0 0 1 0 1 0 1 0 1 0 1 0 1 0 0 0 1 0 0 0 1 0 0 0 0]
  [1 0 0 0 1 0 1 1 1 1 0 0 1 1 1 0 0 1 0 1 0 1 0 1 0 1 0 1 0 0 0 1 0 0 0 1 0 0 0 0]
  [1 0 0 0 1 0 1 0 0 0 0 0 1 0 0 0 0 1 0 1 0 1 0 1 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 0]
  [1 0 0 0 1 0 1 0 0 0 0 0 1 0 0 0 0 1 0 0 1 1 0 1 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 0]
  [1 0 0 0 1 0 1 0 0 0 0 0 1 0 0 0 0 1 0 0 1 1 0 1 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 1]
  [0 1 1 1 0 0 1 0 0 0 0 0 1 1 1 1 0 1 0 0 0 1 0 1 0 0 0 1 0 1 1 1 1 1 0 0 1 1 1 0]
])

; repeat each scanline 4 times interleaved with a blank line
(defn expand-interleaved [pf]
  (letfn [(blank [length] (repeat length 0))]
    (interpose (blank (count (first pf))) (reduce concat (map #(repeat 4 %) pf) )))) 

; decompose 20 bit playfield data aligning relevant bits in PF0, PF1 & PF2
(defn split-registers [[d4 d5 d6 d7 & pfs]]
  (let [pf0 (concat [d7 d6 d5 d4] [0 0 0 0]) [pf1 pf2] (split-at 8 pfs)]
    [pf0 pf1 (reverse pf2)]))

; determine if 40 bit (asymmetric) or 20 bit playfiled and split accordingly
(defn split-playfield [pf]
  (let [width (count pf)]
    (condp = width 
      20 (split-registers pf)
      40 (apply concat (map split-registers (split-at 20 pf)))
      (throw (Exception. "Playfield must be either 20 or 40 bits wide")))))

(defn as-binary [bits]
  (read-string (apply str "2r" bits)))

; turn the bitmaps into valid DASM data
(defn generate-byte-declarations [bitmaps i]
  (let [register (map #(nth % i) bitmaps)
        screen-half (if (< i 3) 'a 'b) 
        empty-line ""
        label (str "PF" (mod i 3) screen-half)
        org-decl (str "ORG $F" (inc i) "00,0")
        opcode ".byte"
        value-array (interpose "," (map as-binary register))]
    [(str label " " org-decl) (apply str  "\t" opcode " " value-array) empty-line]))

(defn generate-playfield [pf]
  (let [bitmaps (map split-playfield (expand-interleaved pf))
        bitmap-count (range (count (first bitmaps)))]
      (apply concat (map (partial generate-byte-declarations bitmaps) bitmap-count))))

(defn export-playfield [bitmap]
(do 
  (spit "playfield.h" "; autogenerated playfield data\n")
  (doseq [line (generate-playfield bitmap)]
    (spit "playfield.h" (str line "\n") :append true))))

; converts cycles to color clocks and pretty prints a report of result
(defn report [& cycles]
  (let [clocks (map #(* % 3) cycles)
        fmt #(map (partial format "%3d") %)]
    (do
      (println "instructions: " (count cycles))
      (println (fmt cycles))
      (println (fmt (reductions + cycles)) (reduce + cycles))
      (println (fmt (reductions + clocks)) (reduce + clocks)))))

