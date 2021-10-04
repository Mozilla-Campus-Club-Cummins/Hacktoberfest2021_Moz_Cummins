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
def Automation(inputString):
    q1="q1"
    q2="q2"
    q3="q3"
    currentState=q1
    for i in inputString:
        # q1 moves to q2 when given a 1, and stays at q1 when given a 0
        if currentState==q1:
            if i=='0':
                nextState=q1
            elif i=='1':
                nextState=q2
        # q2 moves to q3 when given a 0, and stays at q2 when given a 1
        elif currentState==q2:
            if i=='0':
                nextState=q3
            elif i=='1':
                nextState=q2
        # q3 moves to q2 when given a 0 or 1
        elif currentState==q3:
            nextState=q2
        currentState=nextState
    if currentState==q2:
        return True
    else:
        return False

# Regular Expression
import re

# Accept inputString from user
inputString=input("Enter your input string: ")

# To validate that the inputString is made only of 0 and 1
fm=re.fullmatch("[0-1]+",inputString)

# If the inputString is valid then call Automation
if fm!=None:
    print(Automation(inputString))

# Otherwise give a message to user saying inputString is invalid
else:
    print("Invalid Input String")
    print("Please enter a valid input string made of only 0 and 1")
