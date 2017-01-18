/**
 * Created by Yafei on 09/01/2017.
 */

$(document).ready(function() {
    $('.show-playliste').click(function() {
        $('.user-playlist').show();
        $('.user-bewertung').hide();
        $('.neue-bewertung').hide();
        $('.add-playliste').hide();
    });

    $('.show-bewertung').click(function() {
        $('.user-playlist').hide();
        $('.neue-bewertung').hide();
        $('.add-playliste').hide();
        $('.user-bewertung').show();

    });

    $('.write-bewertung').click(function(){
        $('.user-playlist').hide();
        $('.user-bewertung').hide();
        $('.add-playliste').hide();
        $('.neue-bewertung').show();
    });

    $('.add-playliste').click(function(){
        $('.user-playlist').hide();
        $('.user-bewertung').hide();
        $('.neue-bewertung').hide();
        $('.add-playliste').show();
    });
});
