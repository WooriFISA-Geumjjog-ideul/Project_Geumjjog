jQuery(document).ready(function($) {
    $.ajax({
        url: '/post/list',  // 백엔드 API URL
        type: 'GET',
        success: function(posts) {  // 받아온 데이터는 'posts'에 저장됩니다.
            posts.forEach(function(post) {
                var row = '<tr class="text-center">'
                           + '<th scope="row">' + post.postId + '</th>'
                           + '<td class="text-start"><a href="#" class="post-title link-dark" data-no="' 
                           + post.postId + '" style="text-decoration: none">' + post.title + '</a></td>'
                           + '<td>' + post.memberName + '</td>'
                           + '<td>' + post.createdAt + '</td>'
                           + '</tr>';
                $('table tbody').append(row);
            });
        }
    });
});