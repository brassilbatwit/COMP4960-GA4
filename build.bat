mkdir build
javac *.java
jar cfe build/SaladMaker.jar main *.class
xcopy /s/e "assets" "build\assets\"