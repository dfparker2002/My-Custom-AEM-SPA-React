import React, {Component} from 'react';
import ReactWeather from 'react-open-weather';
import {MapTo} from '@adobe/cq-react-editable-components';

require('./Weather.css');

const WeatherEditConfig = {

    emptyLabel: 'Weather',

    isEmpty: function(props) {
        return !props.city || props.city.trim().length < 1;
    }
};

export default class Weather extends Component {
    render() {
        if (this.props.apiKey) {
            return <ReactWeather key={'react-weather' + Date.now()}
                forecast="today" apikey={this.props.apiKey} type="city" city={this.props.city}/>
        } else {
            return <div className="rw-box weather-error">No api key defined! Weather data cannot be retrieved</div>
        }
    }
}

MapTo('wknd-events/components/content/weather')(Weather, WeatherEditConfig);