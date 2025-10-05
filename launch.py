import os
from dotenv import load_dotenv

load_dotenv()

PATH = os.getenv("LIB_PATH") # Apparently setting the variable PATH in .env counts as your actual PATH in env variables
FILE_DIR = os.getenv("FILE_DIR")
RUN = os.getenv("RUN")
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
