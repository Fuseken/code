//An ADT interface to represent an agent

/* an interface represents an 'agent' in the game
 * an 'agent' represents a detective or a thief
 * interface includes functions to interact with the client program. 
 */

//Constants to represent search strategies used by the agents

#define STATIONARY -1 //useful for debugging
#define RANDOM 0
#define LEAST_VISITED 99 // What is this ?!
#define CHEAPEST 1
#define DFS 2


typedef struct agentRep * Agent;


Agent initAgent(Vertex,int,float,int,Graph,char *);
Edge getNextMove(Agent agent,Graph graph);
Vertex getCurrentLocation(Agent);
Vertex getStartLocation(Agent);
void makeNextMove(Agent agent,Edge move);
char * getName(Agent agent);
Vertex getGoal(Agent agent);
void setGoal(Agent agent,Vertex g);
void printAgent(Agent,Graph);

void destroyAgent(Agent agent);
