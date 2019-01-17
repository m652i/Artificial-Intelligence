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
- Fully obeservable vs Not fully observable
  - Chess vs Poker 
    > Seeing the whole board vs not seeing opponents hand
- Deterministic vs Stochastic
  - Chess vs Craps
    > Whether if the next move is directly determined by outcome of the actuators. 
    > Moving a piece, the piece moves to desired location *vs.* throwing a dice, outcome is a random number.
- Episodic vs Squential
  - Chess vs Poker (Again)
    > Chess AI can look at the current board and determine the best move, a poker AI will have to remember the raises and previous bets to determine best move
  - CT scan vs Self Driving car
    > A better example : One shot action, requires no previous memory vs needing to remember all the previous paths taken.
