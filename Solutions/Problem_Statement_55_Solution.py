# A Simple Automaton
# Create a finite automaton that has three states.
# Finite automatons are the same as finite state machines for our purposes.
# Our simple automaton accepts the language of A, defined as {0, 1} and should have three states: q1, q2, and q3.
# Here is the description of the states:
# q1 is our start state, we begin reading commands from here
# q2 is our accept state, we return true if this is our last state
# And the transitions:
# q1 moves to q2 when given a 1, and stays at q1 when given a 0
# q2 moves to q3 when given a 0, and stays at q2 when given a 1
# q3 moves to q2 when given a 0 or 1
# The automaton should return whether we end in our accepted state (q2), or not (true/false).
#
# Your task
# You will have to design your state objects, and how your Automaton handles transitions.
# Also make sure you set up the three states, q1, q2, and q3 for the automaton instance.
# As an aside, the automaton accepts an array of strings, rather than just numbers, or a number represented as a string, because the language an automaton can accept isn't confined to just numbers.
# An automaton should be able to accept any 'symbol.'
#
# Example
# a = Automaton()
# a.read_commands([""1"", ""0"", ""0"", ""1"", ""0""]) ==> False
# We make these transitions:
# input: [""1"", ""0"", ""0"", ""1"", ""0""]
# 1: q1 -> q2
# 0: q2 -> q3
# 0: q3 -> q2
# 1: q2 -> q2
# 0: q2 -> q3
# We end in q3 which is not our accept state, so we return false.

class Automaton:

    # constructor
    def __init__(self):

        # Since initial state is q1, set currentState to q1
        self.currentState="q1"
        self.nextState=""

    def read_commands(self,inputString):
        for i in inputString:

            # q1 moves to q2 when given a 1, and stays at q1 when given a 0
            if self.currentState=="q1":
                if i=='1':
                    self.nextState="q2"

            # q2 moves to q3 when given a 0, and stays at q2 when given a 1
            elif self.currentState=="q2":
                if i=='0':
                    self.nextState="q3"

            # q3 moves to q2 when given a 0 or 1
            elif self.currentState=="q3":
                self.nextState="q2"

            self.currentState=self.nextState

        # if currentState is a final state then return True
        if self.currentState=="q2":
            return True
        # else return False
        else:
            return False

# Accept inputString in the form of list from user
inputString=eval(input("Enter your input string: "))

# Convert it into a set for input validation
set1=set(inputString)
set2={"0","1"}

# difference returns elements present in the first set and not
# in the second set. So if the inputString is valid then
# the difference of set1 and set2 will be an empty set
# To validate that the inputString is made only of 0 and 1
if len(set1.difference(set2))==0:

    # Create instance of Automaton class
    instance=Automaton()

    # Call method read_commands using instance
    print(instance.read_commands(inputString))

# If inputString is not valid then give a message to user saying inputString is invalid
else:
    print("Invalid Input String")
    print("Please enter a valid input string")


# Sample Inputs and Outputs

# Enter your input string: ["1","0","0","1","0"]
# False
#
# Enter your input string: ["1","0","1"]
# True
#
# Enter your input string: ["1","0","1","2"]
# Invalid Input String
# Please enter a valid input string
#
# Enter your input string: ["2","1"]
# Invalid Input String
# Please enter a valid input string
#
# Enter your input string: ["1"]
# True
#
# Enter your input string: ["0"]
# False
#
# Enter your input string: ["1","a"]
# Invalid Input String
# Please enter a valid input string
#
# Enter your input string: []
# False
#
# Enter your input string: [1,0]
# Invalid Input String
# Please enter a valid input string
