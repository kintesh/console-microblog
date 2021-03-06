# console-microblog [![Build Status](https://travis-ci.org/kintesh/console-microblog.svg)](https://travis-ci.org/kintesh/console-microblog)

A console-based social networking application (similar to Twitter) satisfying the scenarios below.


## Installation

Installation requires Java 8 and Maven 

    $ git clone https://github.com/kintesh/console-microblog.git
    $ cd console-microblog
    $ mvn clean install
    $ java -jar target/console-microblog-1.0.jar 


## Details
* Application uses the console for input and output
* Users submit commands to the application. There are four commands. "posting", "reading", etc. 
* Commands always start with the user’s name.
    * posting: `<user name> -> <message>`
    * reading: `<user name>`
    * following: `<user name> follows <another user>`
    * wall: `<user name> wall`
* Assuming that the user will always type the correct commands.
* Assuming that all users will use the same terminal.
* Non-existing users are created as they post their first message (application does not start with a pre-defined list of users).


## Scenarios

### Posting
Alice can publish messages to a personal timeline

    $ Alice -> I love the weather today
    
    $ Bob -> Damn! We lost!
    
    $ Bob -> Good game though.

### Reading
Bob can view Alice’s timeline

    $ Alice
    I love the weather today (5 minutes ago)
    
    $ Bob
    Good game though. (1 minute ago)
    Damn! We lost! (2 minutes ago)

### Following
Charlie can subscribe to Alice’s and Bob’s timelines, and view an aggregated list of all subscriptions

    $ Charlie -> I'm in New York today! Anyone wants to have a coffee?
    
    $ Charlie follows Alice
    
    $ Charlie wall
    Charlie - I'm in New York today! Anyone wants to have a coffee? (2 seconds ago)
    Alice - I love the weather today (5 minutes ago)
    
    $ Charlie follows Bob
    
    $ Charlie wall
    Charlie - I'm in New York today! Anyone wants to have a coffee? (15 seconds ago)
    Bob - Good game though. (1 minute ago)
    Bob - Damn! We lost! (2 minutes ago)
    Alice - I love the weather today (5 minutes ago)



