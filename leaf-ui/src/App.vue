<template>
  <div id="app">
    <NavMenu/>
    <HelloWorld/>

    <router-view/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import NavMenu from "./components/NavMenu";

export default {
  name: 'app',
  components: {
    NavMenu,
    HelloWorld
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /*margin-top: 60px;*/
}
</style>
