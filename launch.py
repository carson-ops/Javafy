import os

PATH = "C:/Program Files/Java/javafx-sdk-25/lib"

# Compile
os.system(f'javac --module-path "{PATH}" --add-modules javafx.controls,javafx.fxml,javafx.media -d src/main/java/classes src/main/java/Main.java')

# Run
os.system(f'java --module-path "{PATH}" --add-modules javafx.controls,javafx.fxml,javafx.media src/main/java/Main.java')
