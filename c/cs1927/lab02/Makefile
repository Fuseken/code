# COMP1927 13x1 lab02


CC=gcc
CFLAGS=-Wall -Werror -lmudflap -fmudflap
.PHONY: clean clobber

all: testStack testArrayQueue testListQueue


testStack: testStack.o arrayStack.o
	$(CC) $(CFLAGS) -o testStack arrayStack.o testStack.o

testStack.o: testStack.c Stack.h Item.h
	$(CC) -c $(CFLAGS) testStack.c

arrayStack.o: arrayStack.c Stack.h Item.h
	$(CC) -c $(CFLAGS) arrayStack.c

testArrayQueue: testQueue.o arrayQueue.o
	$(CC) $(CFLAGS) -o testArrayQueue arrayQueue.o testQueue.o

testListQueue: testQueue.o listQueue.o
	$(CC) $(CFLAGS) -o testListQueue listQueue.o testQueue.o

arrayQueue.o: arrayQueue.c Queue.h Item.h
	$(CC) -c $(CFLAGS) arrayQueue.c

listQueue.o: listQueue.c Queue.h Item.h
	$(CC) -c $(CFLAGS) listQueue.c

testQueue.o: testQueue.c Queue.h Item.h
	$(CC) -c $(CFLAGS) testQueue.c

clean:
	rm -f *.o

clobber: clean
	rm testStack testListQueue testArrayQueue
