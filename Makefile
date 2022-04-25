SOURCES = source.txt

STARSECTOR_LOCATION = ../../

all: compile executable

compile:
	find -name "*.java" > $(SOURCES)
	javac --release 7 @$(SOURCES) -classpath "$(STARSECTOR_LOCATION)*"

executable:
	jar cf jars/ibo-faction.jar data/scripts

