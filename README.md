# Description
This Repo's purpose is to provide a point of sale system demo. It is done with spring boot.

# Requirements 
This was written on a windows machine, and the github repo is configured to maintain windows file line endings. Undefined behavior will occur if you try to run it directly via gradle on a non-windows machine. Use the jar for that.

Java 21 and gradle 8 were used for this project.

# Running
You can run the program via `./gradlew bootRun`

This runs `Application.java`. The spring boot application has one registered controller, `CheckoutController.java`, which is the entrypoint for the app invoked by the `main` function.

The user input is provided in the `input` section of `application.yml`

# Tests
Tests can be run via `./gradlew test`. Note that this will intelligently compile and only run tests that could have been altered by most recent changes. 

The main test cases asked for can be found numbered appropriatelt in `CheckoutControllerTest.java`.