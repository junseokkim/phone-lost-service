<template>

    <v-card outlined>
        <v-card-title>
            LostReportPage # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="LostReportId" v-model="item.lostReportId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="DeviceId" v-model="item.deviceId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="LostReportStatus" v-model="item.lostReportStatus" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'LostReportPageViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/lostReportPages/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

