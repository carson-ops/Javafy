import os

PATH = "C:/Program Files/Java/javafx-sdk-25/lib"
FILE_DIR = "C:/Users/carso/OneDrive/Desktop/yava/Javafy/src/main/java/"
RUN = "C:/Users/carso/OneDrive/Desktop/yava/Javafy/src/main/java/Main.java"
ext = ".java"
allowed = []


DIR = os.listdir(FILE_DIR)

for file in DIR:
    if ext not in file:
        pass
    else:
        allowed.append(FILE_DIR + file)

java_files = " ".join(allowed)

# Compile
os.system(f'javac --module-path "{PATH}" --add-modules javafx.controls,javafx.fxml,javafx.media -d src/main/java/classes {java_files}')

# Run
os.system(f'java --module-path "{PATH}" --add-modules javafx.controls,javafx.fxml,javafx.media {RUN}')
