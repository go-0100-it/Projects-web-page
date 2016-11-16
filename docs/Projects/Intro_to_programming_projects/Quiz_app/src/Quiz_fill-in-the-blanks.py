# cd Documents\Udacity Course Docs\Intro to Programming Nanodegree\Stage 2\Inprogress
# python project.py
from random import randint
import time

levels = ["easy","medium","hard"]
guesses = ["1","2","3","4","5"]

# Setting strings to variables here for easy editing or even future multi language support.
levelOptionsMessage = "To Start Quiz please input difficultly level\nOptions are " + levels[0] + ", " + levels[1] + " or " + levels[2] + ". Enter choice here: "
levelsValidatonMessage = 'You must input either "'+ levels[0] + '", "'+ levels[1] + '", or "'+ levels[2] + '".  Press ENTER to try again...'
levelsConfirmationMessagefirst = "You've selected the "
levelsConfirmationMessageSecond = " level, good luck!"
guessesOptionsMessage = "Oh wait, almost forgot...\n\nHow many chances would you like for answering each blank.  Input a number between 1-5 : "
guessesValidationMessage = "You must enter a number between 1-5, press ENTER to try again."
guessesConfirmationMessagefirst = "Good OK, so you'll have "
guessesConfirmationMessageSecond = " chances at completing each blank, let's get started..."
instruction = "Input the word that should be at blank #"
answerCorrectMessageFirst = ["That's CORRECT!!","You NAILED it!!","That was RIGHT ON THE MONEY!!","You've GOT THIS!!","RIGHT!! this is almost to easy for you.","YOU GOT IT!! Did you write this Quiz?"]
answerCorrectMessageSecond1 = " Let's try blank #"
answerIncorrectMessageFirst = "Sorry that's INCORRECT, You have "
answerIncorrectMessageSecond = " chances left. Press ENTER to try again..."
statementCompleteMessageFirst = "You completed the statement, NICE WORK!!"  
statementCompleteMessageSecond = " Press ENTER for the next one..."
quizCompleteMessage = "CONGATS, YOU FILLED IN ALL THE BLANKS!!!"
tryAgainMessage = "Would you like to take the quiz again, or perhaps try a different level?  Yes/No :"
terminationMessage = "Sorry, you are out of chances, this application will now be terminated, Good Bye!"
thankYouMessage = "Thanks for taking my quiz, Good Bye!"
yes = "yes"

levelsMessages = [levelOptionsMessage, levelsConfirmationMessagefirst, levelsConfirmationMessageSecond, levelsValidatonMessage]
guessesMessages = [guessesOptionsMessage, guessesConfirmationMessagefirst, guessesConfirmationMessageSecond, guessesValidationMessage]

# Lists with lists.  Sublists contain statements with blanks and lists of words to fill the blanks(answers).
easyStatements = [['Level: EASY\nSTATEMENT ONE\n\nHTML ______1______ are what we use to tell a web ______2______ how to display content in a web page.\nMost HTML elements consist of an ______3______ and a ______4______ tag with some content between them.',
					['Elements','browser','opening','closing']],
				 ['Level: EASY\nSTATEMENT TWO\n\nSome ______1______ accept additional values called ______2______ in their opening tags.\nAttributes provide additional information to the browser.\nFor example, the ______3______ tag takes an attribute called ______4______ that defines a URL to link to.',
					['elements','attributes','anchor','href']]]

mediumStatements = [['Level: MEDIUM\nSTATEMENT ONE\n\nCSS stands for ______1______ Style Sheets.\nCSS describes how ______2______ elements are to be displayed.\nCSS ______3______ are used to "find" (or select) HTML ______4______ based on their name, id, class, attribute, etc.',
			 		['Cascading','HTML','selectors','elements']],
 				 	['Level: MEDIUM\nSTATEMENT TWO\n\nA CSS ______1______ starts with ______2______ and ends with */.\nComments are only to help ______3______ read a code file, the computer ______4______ them.\nThey are used to explain the code, and may help when you edit the source code at a later date.',
				 	['comment','/*','PEOPLE','ignores']]]

hardStatements = [['Level: HARD\nSTATEMENT ONE\n\nHTML ______4______s can have an ______1______ and/or ______2______ attribute.\nThe ______1______ attribute assigns a name to the ______4______ it is applied to, and for valid markup, there can be only one ______4______ with that name.\nThe ______2______ attribute assigns a ______2______ name to the ______4______, and that name can be used on many ______4______s within the page.\nCSS allows you to apply ______3______ to a particular id and/or class names.',
					['id','class','styles','element']],
				    ['Level: HARD\nSTATEMENT TWO\n\nA ______1______ has a tree-like structure.\nEach element, attribute and run of text in the markup language becomes a ______2______ in the tree structure.\nThe nodes are defined by their relationship to other ______1______ nodes.\nSome elements are ______3______ of child nodes, and child nodes have ______4______.\nUnderstanding the ______1______ helps you design, debug and maintain your CSS, because the ______1______ is where your CSS and the document\'s content meet up.',
				    ['DOM','node','parents','siblings']],
 				    ['Level: HARD\nSTATEMENT THREE\n\nA markup language uses ______1______s to define the document\'s structure.\nYou mark an ______1______ using ______2______s, which are strings beginning with ______3______ and ending with ______4______.\nMost ______1______ have paired ______2______s, a start ______2______ and an end ______2______.\nFor the start ______2______, place the ______1______ name between ______3______ and ______4______.\nFor the end ______2______, place a / after the ______3______ and before the ______1______ name.',
 				    ['element','tag','<','>']]]

blank = ['______1______','______2______','______3______','______4______']

levelStatements = [easyStatements,mediumStatements,hardStatements]

def optionsLoop(_list, messages):
	"""A function that prompts user to input a value, searches the passed in list for the inputted value.  
	If the value is found in the list, the function returns the index number of that value.
	If the value is not found in the list, the fuction loops.
	Returns int value. Index number of user inputted value within the list passed in.
	Takes a list as input param[0] @_list, the list to search in for the user's inputted value.
	Takes a list as input param[1] @ messages, the list of string messages used to communicate with the user. Requires 4 elements in the list.
	"""
	while(True):
		user_input = raw_input("\n" + messages[0]).lower()
		# Requesting that the user input the desired level.

		if(user_input in _list):
		# Checking if value inputted by user is a valid entery

			result = _list.index(user_input)
			# Coersing inputted string to an integer value.

			print("\n" + messages[1] + user_input + messages[2])
			time.sleep(3)
			# Pausing execution to clarify message

			break
			# Input has been validated, terminate while loop.

		raw_input("\n" + messages[3])
		# If the user inputted a invalid value, re-communicate the required input values.

	return result
	# Returning list of statements corresponding to the selected level.

def correctnessLoop(level, statementNumber, answerNumber, guessesNumber):
	"""A method to loop until user inputs the correct text.
	Takes a list as input param[0] @level.  Used to reference the correct answer string.
	Takes an integer as input param[1] @statementNumber, using to select the current statement by index number.
	Takes an integer as input param[2] @answerNumber, using to refereence the current blanks correct answer by index number.
	"""
	i = 0
	while(True):
		answer = raw_input("\n\n" + level[statementNumber][0] + "\n\n" + instruction + str(answerNumber + 1) + ": ")
		# Getting user input and assigning the value inputted to the answer variable.

		i += 1
		if(answer.lower() == level[statementNumber][1][answerNumber].lower()):
			break
			# Validating inputted answer and if correct terminate loop.

		elif(i >= guessesNumber):
		# Checking if user has reached maximum number of chances

			print("\n" + terminationMessage)
			time.sleep(5)
			# Pausing execution to clarify message
			quit()
			# If 
		else:
			raw_input("\n\n" + answerIncorrectMessageFirst + str(guessesNumber - i) + answerIncorrectMessageSecond)
			# Informing user their inputted answer was not correct.

def answerLoop(level, statementNumber, guessesNumber):
	"""A method to loop through the sublists(list within the list) of the list passed in. 
	Using to loop through blanks/answers list contained in statement list item.
	Takes a list as input param[0] @level. 
	Takes an integer as input param[1] @statementNumber, to be index value of the statement.
	"""
	i = 0
	for answer in level[statementNumber][1]:
	# Initializing loop

		correctnessLoop(level, statementNumber, i, guessesNumber)
		# Calling correctnessLoop to get user input and check for correctness

		completedStatement = level[statementNumber][0] = level[statementNumber][0].replace(blank[i], level[statementNumber][1][i])
		# This code only executes if user entered the correct word.  
		# Replacing the blank with correct word.

		i += 1
		if(i >= len(level[statementNumber][1])):
			print("\n\n" + answerCorrectMessageFirst[randint(0,5)])
			time.sleep(2)
			# Informing user they entered the correct word.  Different message for last blank.

		else:
			print("\n\n" + answerCorrectMessageFirst[randint(0,5)] + answerCorrectMessageSecond1 + str(i + 1) + "...")
			time.sleep(2)
			# Informing user they entered the correct word.  Different message if more blanks to complete in statement.
	return completedStatement

		
def statementLoop(level):
	"""A method for looping through all statements in the list passed in.
	Takes a list as input param[0] @level, the list for looping through.
	"""
	guessesNumber =int(guesses[optionsLoop(guesses, guessesMessages)])

	i = 0
	for statement in level:
		completedStatement = answerLoop(level, i, guessesNumber)
		# Calling answerLoop() to loop through the blanks in the statements.  Getting completedStatement returned for displaying to user.

		i += 1
		if(i < len(level)):
			# Informing user they have successfully competed the statement and we're moving on to the next statement.
			raw_input("\n\n" + completedStatement + "\n\n" + statementCompleteMessageFirst + statementCompleteMessageSecond)

		elif(i == len(level)):
			print("\n\n" + completedStatement + "\n\n" + statementCompleteMessageFirst)
			time.sleep(1.5)

def quizLoop():
	"""A method to enable continuation of the quiz.
	Prompts user with continuation confirmation, will continue quiz until the user inputs anything other than "yes".
	"""
	while(True):
		statementLoop(levelStatements[optionsLoop(levels,levelsMessages)])
		# Calling set level for user to select question level.
		# setLevel() returns the list of statements determined by level selected by user.
		# Passing returned list to statementLoop() to loop through all statements in level.

		if(raw_input("\n\n" + quizCompleteMessage + " " + tryAgainMessage).lower() != yes):
			print("\n" + thankYouMessage)
			time.sleep(3)
			quit()
		# This code runs only after user has completed level statements.  User can decide to try again or not.

quizLoop()
# Method call to start Quiz.