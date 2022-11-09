<template>
   <button class="btn" @click="onClickChange">{{label}}</button>
</template>

<script>
export default {
  name: 'Button',
  props: {
    label: {
      label: String,
      required: true
    }
  },
  methods: {
    onClickChange (e) {
      this.$emit('click', e)
    }
  }
}
</script>

<style scoped>
.btn {
  font-weight: bold;
  margin: 0 35px 20px ;
  height: 45px;
  border-radius: 5px;
  background: #A5CBF7;
  color: white;
}
</style>
