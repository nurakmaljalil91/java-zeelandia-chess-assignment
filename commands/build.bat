@echo off
cd ..
echo building...
javac -d bin -sourcepath res;src src/com/assignment/game/Game.java
cd commands
echo Done! - building