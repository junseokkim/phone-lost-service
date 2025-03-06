<template>

    <v-data-table
        :headers="headers"
        :items="통신서비스차단정보조회"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: '통신서비스차단정보조회View',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            통신서비스차단정보조회 : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/통신서비스차단정보조회'))

            temp.data._embedded.통신서비스차단정보조회.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.통신서비스차단정보조회 = temp.data._embedded.통신서비스차단정보조회;
        },
        methods: {
        }
    }
</script>

