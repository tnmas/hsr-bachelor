const RANKING_API_URL = "https://us-central1-schere-stein-papier-eu.cloudfunctions.net/widgets/ranking";
const PLAY_API_URL = `https://us-central1-schere-stein-papier-eu.cloudfunctions.net/widgets/play`;
export let serverPlayerList = [];

/**
 * Fetching from Server
 * @param url
 * @returns {Promise<any>}
 */
const fetchResponseJson = async function (url) {
    try {
        const response = await fetch(url);
        return await response.json();
    } catch (error) {
        console.error(error);
    }

};

/**
 * Get Ranking
 * @returns {Promise<*>}
 */
const rankingJsonData = async function () {
    return fetchResponseJson(RANKING_API_URL);
};

/**
 * Server Plays
 * @param playerName
 * @param playerHand
 * @returns {Promise<*>}
 */
export const letServerPlay = async function(playerName, playerHand) {
    return await fetchResponseJson(PLAY_API_URL+`?playerName=${playerName}&playerHand=${playerHand}`);
}

/**
 * Rendering the json data
 * @param data
 */
const transformToPlayerList = function (data) {
    let format = /^[a-zA-Z]+$/;
    let transformedPlayerList = [];
    for (let item in data) {
        if (data.hasOwnProperty(item) && item !== "undefined" && item !== "" && format.test(item)) {
            transformedPlayerList.push(data[item]);
        }
    }
    return transformedPlayerList;
}

export function getServerRanking(processServerPlayerList) {
    rankingJsonData().then(response => {
        serverPlayerList = transformToPlayerList(response);
        processServerPlayerList(serverPlayerList);
    });
}


