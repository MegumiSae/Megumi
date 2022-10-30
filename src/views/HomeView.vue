<template>
<body>
    <div class="index-back"><!--首页画面-->
        <div class="backguang1" id="bg1" ><!--背景1-->
            <div class="backguang2" id="bg2">
                <div class="indextext">
                    <div class="title">Final Fantasy</div>
                    <div class="title2">ファイナルファンタジー(最终幻想)</div>
                    <div class="video">
                        <button type="button"  id="stat" class="butt" @click="openvideo()"><video src="../video/最终幻想三十周年官方纪念视频.mp4" height="300" width="500" autoplay="autoplay" muted="muted" loop="loop"></video></button>
                        <div class="img-icon" id="statt"></div>
                    </div>
                    <div class="but">
                        <a href="#center"><button class="but1 but" id="but1">了解更多</button></a>
                        <a href="##foot-"><button class="but2 but" id="but2">人物介绍</button></a>
                    </div>
                </div>

            </div><!--蒙版-->
        </div>
    </div>
    <div class="center" id="center">
        <div class="center-left">
            <div class="center-text">最终幻想系列</div>
            <div class="center-text2">最高の「物語」を提供することで、世界中の人々の幸福に貢献する</div>
            <div class="center-box">
                <ul class="center-box-box">
                        <li class="libox">
                            <a href="Page.html"><div class="libox-img"></div>
                            <div class="lobox-text">Final Fantasy VII</div>
                            <div class="lobox-text2">悲鸣的星球之命</div></a>
                        </li>
                    <li class="libox">
                        <a href="Page2.html"><div class="libox-img2"></div>
                        <div class="lobox-text">FINAL FANTASY X</div>
                        <div class="lobox-text2">原罪与父子情</div></a>
                    </li>
                    <li class="libox">
                        <a href="Page3.html"><div class="libox-img3"></div>
                        <div class="lobox-text">Final Fantasy XIII</div>
                        <div class="lobox-text2">新的水晶传说</div></a>
                    </li>
                    <li class="libox">
                        <a href="Page4.html"><div class="libox-img4"></div>
                        <div class="lobox-text">Final Fantasy XV</div>
                        <div class="lobox-text2">真王拯救星球的物语</div></a>
                    </li>
                    <li class="libox">
                        <a href="Page5.html">
                        <div class="libox-img5"></div>
                        <div class="lobox-text">FINAL FANTASY XVI</div>
                        <div class="lobox-text2">中世纪背景的复仇物语</div></a>
                    </li>
                    <li class="libox">
                        <a href="login.html">
                        <div class="libox-img6"></div>
                        <div class="lobox-text">以及更多</div>
                        <div class="lobox-text2"></div></a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="center-img">
        </div>
    </div>
    <div class="foot" id="#foot-">
        <div class="foot-right">
            <div class="foot-text">人物介绍</div>
            <div class="foot-text2">各自的物语</div>
            <div class="foot-box">
                <ul class="foot-box-box">
                    <li class="footlibox">
                        <a href="Page.html">
                        <div class="footlibox-img"></div>
                        <div class="lobox-text">克劳德</div>
                        <div class="lobox-text2">Final Fantasy VII</div></a>
                    </li>
                    <li class="footlibox">
                        <a href="Page2.html">
                        <div class="footlibox-img2"></div>
                        <div class="lobox-text">提达</div>
                        <div class="lobox-text2">FINAL FANTASY X</div></a>
                    </li>
                    <li class="footlibox">
                        <a href="Page3.html">
                        <div class="footlibox-img3"></div>
                        <div class="lobox-text">埃克莱尔·法隆</div>
                        <div class="lobox-text2">Final Fantasy XIII</div></a>
                    </li>
                    <li class="footlibox">
                        <a href="Page4.html">
                        <div class="footlibox-img4"></div>
                        <div class="lobox-text">诺克提斯·路西斯·伽拉姆</div>
                        <div class="lobox-text2">Final Fantasy XV</div></a>
                    </li>
                    <li class="footlibox">
                        <a href="Page5.html">
                        <div class="footlibox-img5"></div>
                        <div class="lobox-text">克莱夫·罗斯菲尔德</div>
                        <div class="lobox-text2">FINAL FANTASY XVI</div></a>
                    </li>
                    <li class="footlibox">
                        <a href="login.html">
                        <div class="footlibox-img6"></div>
                        <div class="lobox-text">更多人物</div>
                        <div class="lobox-text2"></div></a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="foot-img"></div>
    </div>

</body>
</template>

<script>
export default {
  name: 'HomeView',
  methods:{
    openvideo(){
        window.open('video.html',"最终幻想30周年纪念视频","width=1580,height=900,location=0");
    }
  }
}
</script>

<style >
  @import '../../public/Css/index.css';
</style>