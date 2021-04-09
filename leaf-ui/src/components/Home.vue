<template>
    <div>
    <el-container>
        <el-header><NavMenu/></el-header>
        <el-main>Main</el-main>
        <el-footer>Footer</el-footer>
    </el-container>
    </div>
</template>

<script>
    import NavMenu from "../components/NavMenu.vue";
    export default {
        name: "Home",
        components: {NavMenu}
    }
</script>

<style scoped>

</style>