mkdir build
javac *.java
jar cfe build/SaladMixer.jar main *.class
xcopy /s/e "assets" "build\assets\"