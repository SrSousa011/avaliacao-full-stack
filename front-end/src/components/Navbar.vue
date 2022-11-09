<template>
<div class="nav-wrapper">
  <nav class="navbar">
    <img src="https://mypolicy.tokiomarine-life.sg/images/logo-reg.png">
    <div class="menu-toggle" :class="{'is-active': openMenu}" id="mobile-menu" @click="openMenu = !openMenu">
      <span class="bar"></span>
      <span class="bar"></span>
      <span class="bar"></span>
    </div>
    <ul class="nav" :class="{'mobile-nav': openMenu}">
      <li v-for="route in routes" :key="route.name" class="nav-item" @click="openMenu = !openMenu">
        <router-link :to="route.to">{{route.name}}</router-link>
      </li>
    </ul>
  </nav>
</div>
</template>

<script>
export default {
  name: 'Navbar',
  data: () => {
    return {
      openMenu: false
    }
  },
  props: {
    routes: {
      type: Array,
      required: true
    }
  }
}
</script>

<style>

.nav-wrapper {
  width: 100%;
  padding: 1%;
  position: sticky;
  top: 0;
  background-color: #A5CBF7;
}

.navbar {
  display: grid;
  grid-template-columns: 1fr 3fr;
  align-items: center;
  height: 50px;
  overflow: hidden;
}

.navbar img {
  height: 43px;
  width: auto;
  justify-self: start;
  margin-left: 20px;
}

.navbar ul {
  list-style: none;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
}

.nav-item a {
  color: white;
  text-decoration: none;
  transition: color 0.3s ease-out;
}

.menu-toggle {
  justify-self: end;
  margin-right: 30px;
  display: none;
}

</style>
