import React, {Component} from 'react';
import {MapTo} from '@adobe/cq-react-editable-components';
import Clock from 'react-live-clock';

export default class Time extends Component {

    render() {
            return <div className="Time-class">
            <Clock
                    format={'d dddd YYYY, h:mm:ss A'}
                    ticking={true}
                    timezone={'Asia/Kolkata'} />
            </div>;
    }
}

MapTo('wknd-events/components/content/time')(Time);