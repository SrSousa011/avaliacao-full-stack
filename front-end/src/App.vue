<template>
  <Main>
    <router-view/>
  </Main>
</template>

<script>
import Main from '@/layouts/Main.vue'
export default {
  name: 'App',
  components: {
    Main
  }
}
</script>

<style>
body {
  background-color: #f0f0f0;
}
</style>
