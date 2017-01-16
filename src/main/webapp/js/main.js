/**
 * Created by Yafei on 09/01/2017.
 */

$(document).ready(function() {
    $('.show-playliste').click(function() {
        $('.user-playlist').show();
        $('.user-bewertung').hide();
    });

    $('.show-bewertung').click(function() {
        $('.user-playlist').hide();
        $('.user-bewertung').show();
    });
});
