  processor 6502
  include "vcs.h"
  include "macro.h"

  ;-----------------------------------------------------------------

  SEG
  ORG $F000

Reset
  CLEAN_START

  ;-----------------------------------------------------------------
  ; Once-only init section

;  lda #$A2
;  sta COLUP0
  lda #$6C
  sta COLUPF
  lda #0
  sta COLUBK
  lda #%00000000
  sta CTRLPF
  ;-----------------------------------------------------------------
StartOfFrame
  ; Start of vertical blank processing
  lda #0
  sta PF0
  sta PF1
  sta PF2
  sta COLUBK
  sta VBLANK

  VERTICAL_SYNC
  ;-----------------------------------------------------------------
  ; 37 scanlines of vertical blank

  ldx #0
VerticalBlank
  sta WSYNC
  inx
  cpx #37
  bne VerticalBlank

  ;-----------------------------------------------------------------
  ; 192 scanlines per frame
  ; 76 machine cycles/228 color clocks per scanline
  ; x=PF0,y=PF1,z=PF2             (XYZ=right-side of screen)
  ; 1<=xyz<68<=yz<84<=Xz<116<=XY<148<=YZ<164<=Z<196<=xyz<229

                  ldx #0
Kernel                                  ;  cycles    colorClocks
                  SLEEP 6               ;  6         
                  sta WSYNC             ;  3         228
                  
                  lda #$6C              ;  2           
                  sta COLUPF            ;  3
                  lda PF0a,x            ;  4
                  sta PF0               ;  3
                  lda PF1a,x            ;  4
                  sta PF1               ;  3          
                  lda PF2a,x            ;  4          69
                  sta PF2               ;  3
                  SLEEP 2               ;  2          84
                  lda PF0b,x            ;  4
                  sta PF0               ;  3
                  SLEEP 4               ;  4         117
                  lda PF1b,x            ;  4         
                  sta PF1               ;  3         
                  SLEEP 2               ;  2         
                  lda #$A2              ;  2         153
                  sta COLUPF            ;  3         
                  lda PF2b,x            ;  4         174
                  sta PF2               ;  3         
                  
                  inx                   ;  2           
                  cpx #192              ;  2         
.endscan          bne Kernel            ;  3 (2)     204
  ; ENSURE Kernel to .endscan is 76 cycles

  ;-----------------------------------------------------------------
  ; enter Vertical blank

  lda #%01000010
  sta VBLANK

  ; 30 scanlines of overscan

  ldx #0
Overscan  
  sta WSYNC
  inx
  cpx #30
  bne Overscan

  jmp StartOfFrame

  ;-----------------------------------------------------------------
  include "playfield.h"
  
  ;-----------------------------------------------------------------

  ORG $FFFA

InterruptVectors
  .word Reset ; NMI
  .word Reset ; RESET
  .word Reset ; IRQ

  END

