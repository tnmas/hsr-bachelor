import {
    eventListenerReturnBackButton,
    eventListenerPlayButton,
    displayGameList,
    eventListenerGameListClick,
    displayRankingList
} from "./common.js";

import {getServerRanking, serverPlayerList} from "./dataService.js";

const serverEnvButton = document.getElementById("server-env-button");

/**
 * EventListeners
 */

serverEnvButton.addEventListener("click", function () {
    window.location.href = "local.html";
}, false);

eventListenerPlayButton(serverPlayerList);

eventListenerReturnBackButton("server", serverPlayerList);

eventListenerGameListClick("server", serverPlayerList);

function init() {
    getServerRanking(displayRankingList);
    displayGameList();
}

init();
