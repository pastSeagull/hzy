<template>
  <div id="app">
    <NavMenu/>

    <router-view/>
  </div>
</template>

<script>
import NavMenu from "./components/NavMenu";

export default {
  name: 'app',
  components: {
    NavMenu
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
