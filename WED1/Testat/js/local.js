import {
    eventListenerGameListClick,
    displayGameList,
    eventListenerPlayButton,
    eventListenerReturnBackButton,
    displayRankingList
} from "./common.js";

const playerList = [
    {"user": "Michael", "win": 0, "lost": 0},
    {"user": "Peter", "win": 0, "lost": 0},
    {"user": "Matt", "win": 0, "lost": 0},
    {"user": "Efrem", "win": 0, "lost": 0},
    {"user": "Dave", "win": 0, "lost": 0},
    {"user": "Erena", "win": 0, "lost": 0},
];

const localEnvButton = document.getElementById("local-env-button");

/**
 * EventListeners
 */

localEnvButton.addEventListener("click", function () {
    window.location.href = "server.html";
}, false);

eventListenerPlayButton(playerList);

eventListenerReturnBackButton("local", playerList);

eventListenerGameListClick("local", playerList);

function init() {
    displayGameList();
    displayRankingList(playerList);
}

init();






