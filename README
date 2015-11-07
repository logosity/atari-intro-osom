# Atari VCS Programming Demo
These are the supporting files for the lightning talk I did on Atari VCS (2600) programming for the [Open-Source, Open-mic meetup](http://www.meetup.com/Chicago-Open-Source-Open-Mic/) on November 5th 2015

The slides are available on [speakerdeck](https://speakerdeck.com/logosity)

# Demo
The demo itselfs is a simple example of creating asymmetric playfields. The intent is to show the precise timing needed for atari scanline kernels (for fun change the SLEEP 6 on line 53 of demo.asm to SLEEP 7 and reload the binary)

# Compiling and installing

You'll need to install [Stella](http://stella.sourceforge.net/downloads.php) to run the demo 
You'll also need a copy of [DASM[(http://sourceforge.net/projects/dasm-dillon/files/dasm-dillon/) (this was written against 2.20.11)

the command line I used (mac/linux) to compile (assumes your default roms directory for stella is at ../roms):
`prog=demo; dasm ${prog}.asm -s${prog}.sym -l${prog}.lst -o${prog}.bin -f3 -v5 && cp ${prog}.{bin,lst,sym} ../roms/`

# Links

At the end of the talk I provided some links to further information, here they are:

* [Atari for Newbies](In depth, and fairly technical look at how these games were written) Tutorial. Excellent Introduction by Andrew Davie
* [Easy 6502](In depth, and fairly technical look at how these games were written) Nice intro to 6502 programming; in browser emulator; shows registers memory, etc

* [6502.org](http://www.6502.org/tutorials/6502opcodes.html): Great 6502 resource site; link is to a handy opcode reference
* [Atari Color Chart](http://www.randomterrain.com/atari-2600-memories-tia-color-charts.html): Colors are tricky on the VCS; this will help a lot
* [Support Source code](https://github.com/logosity/atari-intro-osom) for this presentation
* [Slides](https://speakerdeck.com/logosity/atari-vcs-programming-a-very-brief-introduction) The slides used for presentation
* [Atari: Game Over]() Great documentary to get a sene of the history. Plus, the mystery of ET cartridges solved!
* [Racing the Beam: The Atari Video Computer System](http://www.amazon.com/Racing-Beam-Computer-Platform-Studies/dp/026201257X): In depth, and fairly technical book about how games for the platform were written

