### API Tennis players

Sur port 8080/tennis :

* /getAllPlayers => return all the players sorted by descending rank.
* /getPlayerById/{id} => return the player with the provided id
* /getStats => return an StatsDto object which contains the country with the highest amount of points, the average BMI of all players and the median height of all players.