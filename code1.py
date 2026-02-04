import random;

def main():

  # Performance measure
  perf = 0;
  S = input("Please enter S: ");
  P = input("Please enter P: ");

  # Initializing Vacuum
  vacuum = {
    "direction" : 1,
    "current" : 0
  }

  # Initializing A, B, C, D as clean(true) or dirty(false), 
  # and the vacuum's perception of each
  locale = {
      0 : ["A",True, True],
      1 : ["B",True, True],
      2 : ["B",True, True],
      3 : ["B",True, True]
  }

  # Initial assignment of A, B, C, and D
  for key, value in locale.items():
      if (random.random() < 0.8):
          locale[key][1] = True;
      else:
          locale[key][1] = False;
      
  
  # 10,000 time steps
  for i in range(10000):
  
    # Does each square get dirt on it at the start of step
    for key, value in locale.items():
      if (random.random() >= 0.8):
          locale[key][1] = False;
    
    # Check if in A or D
    if (vacuum["current"] == 0):
      vacuum["direction"] = 1;
    elif (vacuum["current" == 3]):
      vacuum["direction"] = -1;

    # Agent's view of a square's dirtiness is wrong
    if (random.random() < P):

      # Vacuum thinks tile is clean
      if(locale[vacuum["current"]][1] == False):
        vacuum["current"] += vacuum["direction"];
      
      # Vacuum thinks tile is dirty
      if(locale[vacuum["current"]][1] == True):
        
        # Vacuum suck works
        if (random.random() < S):
          locale[vacuum["current"]][1] = True;

    # Agent's view of a square's dirtiness is right
    else: 

      # Vacuum thinks tile is clean
      if(locale[vacuum["current"]][1] == True):
        vacuum["current"] += vacuum["direction"];
      
      # Vacuum thinks tile is dirty
      if(locale[vacuum["current"]][1] == False):

        # Vacuum suck works
        if (random.random() < S):
          locale[vacuum["current"]][1] = True;

    # Point assignment at end of step
    for key, value in locale.items():
      if (locale[key][1] == True):
        perf = perf + 1;
          
  # Final print statement
  print("The resulting performance measure is " + perf);  
