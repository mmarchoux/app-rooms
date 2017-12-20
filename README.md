# app-rooms


## RoomContextState

|  **Name**  |   room     |   statusLight   |   statusNoise  |   levelLight     |   levelNoise     |
| ---------- | ---------- | --------------- | -------------- | ---------------- | ---------------- |
|  **Type**  |   String   |      String     |     String     |       int        |       int        |


### Methods
#### Room
* getRoom()
* setRoom(String room)

#### statusLight
* getStatusLight()
* setStatusLight(String statusL)

#### levelLight
* getLevelLight()
* setLevelLight(int levelL)

#### statusNoise
* getStatusNoise()
* setStatusNoise(String statusN)

#### levelNoise
* getLevelNoise()
* setLevelNoise(int levelN)


## RoomContextManager

* retrieveRoomContextState(String room) : create a new state for the room room
* switchLight(final RoomContextState state, String room)

