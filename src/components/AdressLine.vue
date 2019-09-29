<template>
  <div>{{ `${srcAdress.lineOne}, ${srcAdress.street} ${srcAdress.streetNumber}, ${srcAdress.zip} ${srcAdress.town} -> ${dstAdress.lineOne}, ${dstAdress.street} ${dstAdress.streetNumber}, ${dstAdress.zip} ${dstAdress.town}` }}</div>
</template>

<script>
export default {
  name: 'AdressLine',
  props: {
    srcAdress: {
      type: Object,
      required: true
    },
    dstAdress: {
      type: Object,
      required: true
    }
  }
};
</script>