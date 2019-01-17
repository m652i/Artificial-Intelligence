## Artificial-Intelligence
Practicing building AI's to solve puzzles.

A different approach to programming.

Instead of us coders focusing on solving the problems,
we have to design ways to feed the right conditions to programs and let them solve the problem.

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

====================**Solitare** 

Fully obeservable :     True

Deterministic     :     True

Episodic          :     False

Static            :     True

Discrete          :     True

Single Agent      :     True
