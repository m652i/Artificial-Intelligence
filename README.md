## Artificial-Intelligence
Practicing building AI's to solve puzzles.

A different approach to programming.

Instead of us coders focusing on solving the problems,
we have to design ways to feed the right conditions to programs and let them solve the problem.

Most recent project : https://www.youtube.com/watch?v=sfs5ltGhYoo&feature=youtu.be

Start with identifing the PEAS!
- Performance 
- Enviorment 
- Actuators  
- Sensors 

For example, chess AI : 
- Performance : Win, speed
- Enviorment : The chess board
- Actuators : Moving the pieces
- Sensors : Seeing the board

Or self driving cars : 
- Performance : Reaches goal safely, maybe speed depending on situations, but many more. 
- Enviorment : The public roads! 
- Actuators : Steering, braking, lights, signals, wipers, etc. 
- Sensors : Camera, motion sensors, G-force sensors etc. 

Then we shall break down the types of enviorments! 

*Some enviorments might not be clear which type it falls into, but **we will have to** decide which type we choose our AI to be.*

- Fully obeservable vs Not fully observable
  - Chess vs Poker 
    > Seeing the whole board vs not seeing opponents hand
- Deterministic vs Stochastic
  - Chess vs Craps
    > Whether if the next move is directly determined by outcome of the actuators. 
    > Moving a piece, the piece moves to desired location *vs.* throwing a dice, outcome is a random number.
- Episodic vs Squential
  - CT scan vs Self Driving car
    > One shot action that requires no previous memory vs needing to remember all the previous paths taken.
- Static vs Dynamic
  - Chess board vs Roads
    > The Chess board will not change, the public road is fill with constant uncertainties. 
- Discrete vs Continuous
    >If the enviornment can be divided into sections (percepts and actions).
    >A path finding agls that can be sectioned vs 1 path in continuous.
- Single Agent vs Multi Agent
  - Single Agent : 8 puzzle, sudoku, solitare, etc. 
  - Multi Agent type 1 : Chess, Poker, etc.
    > The other agent is human
  - Multi Agent type 2 : Multiple AI working together
  
Since all types are 2 options only, we can create a True, False table. 
(My apologies for the mess, but I didn't find table formats in the format guide.)

==============**Solitare**==**Chess**====**Backgammon**==**Poker**==**Self Driving**

Fully obeservable====True======True======True======False======False

Deterministic=======True======True======False======True======False

Episodic==========False======False======False======False======False

Static ============True======True======False======False======False

Discrete===========True======False======True======False======False

Single Agent========True======False======False======False======False

And so following this table, we can see the more Falses, the more difficult it is for the AI to perform well. 
(Which is pretty understandable, since answering move Trues means a more static enviornment and vise versa. A complicated enviornment of course is much more difficult for AI to handle.)

But taking the time before starting AI projects and breaking it down into these will really help with the decisions on how to approach building the right AI for the job!
