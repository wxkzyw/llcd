$(document).ready(function () {

    //nav 切换
    $(".nav-list>li").click(function(){
        $(this).addClass("active").siblings().removeClass('active');
    })

    //语言切换
    $(".language li").click(function(){
        $(this).addClass("active").siblings().removeClass('active');
    })

    //导航换色
    $(window).scroll(function(){
        var  bHeight = $(".navbar").height();
        var  sHeight = $(document).scrollTop();
        if( sHeight > bHeight ){
            $(".navbar").addClass("nav-shadow")
        }else{
            $(".navbar").removeClass("nav-shadow")
        }
    })


    //导航菜单图标变色
    $("#icon-menu").click(function(){
        $(this).toggleClass("icon-menu")
        $('.navbar-header').toggleClass("bg-white")
    })

    //导航下拉图标切换
    $('#nav-menu .dropdown').click(function(){
        $(this).find('.caret').toggleClass("drop-down")
    })

    //banner
    var swiper1 = new Swiper('.swiper-container',{
        grabCursor : true,
        autoplay: true,
        loop:true,
        pagination:{
            el: '.swiper-pagination',
            type: 'bullets',
            bulletElement : 'li',
            clickable :true,
        }
    });


    //return top
    $(window).scroll(function(){
        if( $(this).scrollTop()>100 ){
            $("#back-top").fadeIn(500)
        }else{
            $("#back-top").fadeOut(500)
        }
    })
    $("#back-top").click(function(){
           $('body,html').animate({scrollTop:0},1000);
    })

})