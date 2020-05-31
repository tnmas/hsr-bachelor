import {letServerPlay, getServerRanking} from "./dataService.js";

const gameItemsList = [
    {"id": "schere-input", "value": "Schere"},
    {"id": "stein-input", "value": "Stein"},
    {"id": "papier-input", "value": "Papier"},
    {"id": "brunnen-input", "value": "Brunnen"},
    {"id": "streichholz-input", "value": "Streichholz"}
];

const winLossList = {
    "Schere": {
        "Papier": "1",
        "Streichholz": "1",
        "Stein": "0",
        "Brunnen": "0"
    },
    "Stein": {
        "Streichholz": "1",
        "Schere": "1",
        "Papier": "0",
        "Brunnen": "0"
    },
    "Papier": {
        "Stein": "1",
        "Brunnen": "1",
        "Schere": "0",
        "Streichholz": "0"
    },
    "Streichholz": {
        "Papier": "1",
        "Brunnen": "1",
        "Schere": "0",
        "Stein": "0"
    },
    "Brunnen": {
        "Stein": "1",
        "Schere": "1",
        "Papier": "0",
        "Streichholz": "0"
    },
}

export const player = document.getElementById("player");
const noNameGiven = document.getElementById("no-name-given-id");
const showMeTheList = document.getElementById("show-me-the-list-div");
const letsPlay = document.getElementById("lets-play-div");
const gameItems = document.getElementsByClassName("game-items");
const computerChoices = ["Schere", "Stein", "Papier", "Brunnen", "Streichholz"];
const tableBody = document.getElementById("history-list-tbody");
const inputToBeFilled = document.getElementById("tobe-filled-input");
const nextRound = document.getElementById("center-round-p");
const centerVs = document.getElementById("center-vs-p");
const getTimeInSeconds = document.getElementById("get-time-in-seconds-span");
const ranking = document.getElementById("player-list-ol");
const itemsUl = document.getElementById("items-ul");
const returnBackButton = document.getElementById("return-back-button");
const playButton = document.getElementById("play-button");
const displayName = document.getElementById('name-value-strong');
let win;
let choice;

function createRankList(playerList) {
    let rank = 0;
    let previousWin = null;

    while (ranking.firstChild) {
        ranking.removeChild(ranking.firstChild);
    }

    for (let player of playerList) {
        if (previousWin !== player.win) {
            rank++;
        }
        previousWin = player.win;
        const liElement = document.createElement("li");
        const pElement = document.createElement("p");
        liElement.textContent = `${rank}. Rang mit ${player.win} Siegen`;
        pElement.textContent = `${player.user}`;
        ranking.appendChild(liElement);
        ranking.appendChild(pElement);
    }
}

/**
 * creates the list of the game buttons.
 * @param gameItemsList
 * @returns {string}
 */
function createGameListElement(gameItemsList) {
    return gameItemsList.map(item => `
        <li>
        <input id="${item.id}" class="game-items change-pointer" value="${item.value}" type="button" name="${item.id}">
</li>
    `).join('');
}

/**
 * We hide the div
 * @param idName
 */
function hideDiv(idName) {
    if (idName.classList.contains("shown")) {
        idName.classList.remove("shown");
    }
    idName.classList.add("hidden");
}

/**
 * Display the hidden div
 * @param idName
 */
function showDiv(idName) {
    if (idName.classList.contains("hidden")) {
        idName.classList.remove("hidden");
    }
    idName.classList.add("shown");
}

/**
 * We search the player with their name.
 * @param playerName
 * @param playerList
 * @returns {{user: string, win: number} | {user: string, win: number} | {user: string, win: number} | {user: string, win: number} | {user: string, win: number}}
 */
function findPlayerByName(playerName, playerList) {
    return playerList.find(player => playerName === player.user);
}

/**
 * Compares the players' score
 * @param player1
 * @param player2
 * @returns {number}
 */
function comparePoints(player1, player2) {
    return player2.win - player1.win;
}

/**
 * We increment the player's score.
 * @param playerName
 * @param counter
 * @param playerList
 * @returns {boolean}
 */
function scoredPoint(playerName, counter, playerList) {
    let player = findPlayerByName(playerName, playerList);
    if (player) {
        player.win += counter;
        return true;
    }
    return false;
}

/**
 * Increment lost points
 * @param playerName
 * @param counter
 * @param playerList
 * @returns {boolean}
 */
function lostPoint(playerName, counter, playerList) {
    let player = findPlayerByName(playerName, playerList);
    if (player) {
        player.lost += counter;
        return true;
    }
    return false;
}

/**
 *   Here we check, who want and put the values in the history list and increment the players
 *   score if he/she wins.
 *   @param choice
 *   @param playerClickValue
 *   @param playerClick
 * @param win
 */
function game(choice, playerClickValue, playerClick, win) {
    if (choice === playerClickValue) {
        // Equal
        playerClick.classList.add("equal");
        playerClickValue = `=${playerClickValue}`;
    } else if (win === 1) {
        // Player Wins
        playerClick.classList.add("correct");
        playerClickValue = `✔${playerClickValue}`;
    } else {
        // Player loses
        playerClick.classList.add("wrong");
        playerClickValue = `✗${playerClickValue}`;

    }
    playerClick.value = playerClickValue;
}

/**
 * if the Spiel button is clicked
 */
function wantsToPlay(playerList) {
    let playerName = player.value;
    if (playerName === "") {
        noNameGiven.textContent = "*Please provide your name!";
        player.classList.add("empty-input");
        player.focus();
    } else {
        if (!findPlayerByName(playerName, playerList)) {
            playerList.push({"user": playerName, "win": 0, "lost": 0});
        }
        displayName.textContent = playerName;
        showDiv(letsPlay);
        hideDiv(showMeTheList);
    }
}

function updateView(environment, playerList) {
    if (environment === "server") {
        getServerRanking(displayRankingList);
    } else {
        displayRankingList(playerList);
    }
}

/**
 * If the Zurück zum Ranking button is clicked, we hide the game div
 * and show the Ranking div
 */
function back(environment, playerList) {
    player.value = "";
    noNameGiven.textContent = "";
    player.classList.remove("empty-input");
    updateView(environment, playerList);
    hideDiv(letsPlay);
    showDiv(showMeTheList);
}

/**
 *  Here we show the timer and call the function game to see who won.
 *  @param playerList
 *  @param eventTarget
 * @param environment
 */
function display(playerList, eventTarget, environment) {
    let equal = false;
    let wrong = false;
    let correct = false;
    let alreadySet = false;
    let runOnce = false;
    let playerName = player.value;
    let playerClick = eventTarget;
    let playerClickValue = playerClick.value;
    let computerGuess = computerChoices[Math.floor(Math.random() * computerChoices.length)];
    let playerWon = parseInt(winLossList[playerClickValue][computerGuess]);
    let timeInSeconds = getTimeInSeconds.textContent;
    const timeCounter = setInterval(async function () {
        showDiv(nextRound);
        hideDiv(centerVs);
        playerClick.classList.add("active");
        for (let i = 0; i < gameItems.length; i++) {
            if (gameItems[i].id !== playerClick.id) {
                gameItems[i].classList.add("inactive");
            }
        }
        returnBackButton.classList.add("inactive");
        if (!runOnce) {
            if (environment === "server") {
                await serverPlays(playerName, playerClickValue);
                computerGuess = choice;
                playerWon = +win;
            }
            inputToBeFilled.value = computerGuess
            game(computerGuess, playerClickValue, playerClick, playerWon);
            runOnce = true;
        }

        timeInSeconds--;
        getTimeInSeconds.textContent = timeInSeconds;

        if (!alreadySet) {
            let rowHistory = tableBody.insertRow();
            let cellResultat = rowHistory.insertCell();
            let cellSpieler = rowHistory.insertCell();
            let cellGegner = rowHistory.insertCell();
            cellSpieler.innerHTML = playerClickValue;
            cellGegner.innerHTML = computerGuess;
            if (playerClick.classList.contains("equal")) {
                cellResultat.innerHTML = "=";
                cellResultat.classList.add("equal");
                equal = true;
            } else if (playerClick.classList.contains("wrong")) {
                cellResultat.innerHTML = "✗";
                cellResultat.classList.add("wrong");
                wrong = true;
            } else if (playerClick.classList.contains("correct")) {
                cellResultat.innerHTML = "✔";
                cellResultat.classList.add("correct");
                correct = true;
            }
            alreadySet = true;
        }

        if (timeInSeconds < 0) {
            hideDiv(nextRound);
            showDiv(centerVs);
            playerClick.classList.remove("active");
            if (equal) {
                playerClick.classList.remove("equal");
            } else if (wrong) {
                lostPoint(playerName, 1, playerList);
                playerClick.classList.remove("wrong");
            } else if (correct) {
                scoredPoint(playerName, 1, playerList);
                playerClick.classList.remove("correct");
            }
            playerClick.value = playerClickValue;
            for (let i = 0; i < gameItems.length; i++) {
                if (gameItems[i].id !== playerClick.id) {
                    gameItems[i].classList.remove("inactive");
                }
            }
            returnBackButton.classList.remove("inactive");
            inputToBeFilled.value = "?";
            clearInterval(timeCounter);
            getTimeInSeconds.textContent = "3";
        }
    }, 1000);
}


function assignChoiceAndWinValues(data) {
    choice = data.choice;
    win = data.win;
}

async function serverPlays(playerName, playerHand) {
    await letServerPlay(playerName, playerHand).then(assignChoiceAndWinValues);
}


/**
 * EventListener while playing
 * @param environment
 * @param playerList
 */
export function eventListenerGameListClick(environment, playerList) {
    itemsUl.addEventListener("click", function (event) {
        display(playerList, event.target, environment);
    }, false);
    itemsUl.addEventListener("mouseover", function (event) {
        event.target.classList.add("mouse-over");
        setTimeout(function () {
            event.target.classList.remove("mouse-over");
        }, 1000);
    }, false);
}

/**
 * EventListener Return Back Button
 */
export function eventListenerReturnBackButton(environment, playerList) {
    if (returnBackButton) {
        returnBackButton.addEventListener("click", function () {
            back(environment, playerList);
        }, false);
    }
}

/**
 * EventListener Play Button
 */
export function eventListenerPlayButton(playerList) {
    if (playButton) {
        playButton.addEventListener("click", function () {
            wantsToPlay(playerList);
        }, false);
    }
}


/**
 * Lists the game items
 */
export function displayGameList() {
    itemsUl.innerHTML = createGameListElement(gameItemsList);
}

/**
 * Shows the players' list
 * @param playerList
 */
export function displayRankingList(playerList) {
    createRankList(playerList.sort(comparePoints));
}

