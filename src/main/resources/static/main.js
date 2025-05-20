import * as olMap from 'ol/Map';
import * as olView from 'ol/View';
import * as olTileLayer from 'ol/layer/Tile';
import * as olOSM from 'ol/source/OSM';
import * as olTileWMS from 'ol/source/TileWMS';
import * as olProj from 'ol/proj';
import * as olControl from 'ol/control';

// 전역 네임스페이스 처럼 작용
window.ol = {
  Map: olMap.default,
  View: olView.default,
  layer: {
    Tile: olTileLayer.default
  },
  source: {
    OSM: olOSM.default,
    TileWMS: olTileWMS.default
  },
  proj: olProj,
  control: olControl
};

const zoomControl = new ol.control.Zoom({
  className: 'ol-zoom ol-custom-topright' // 클래스로 위치 조절
});

const scaleLineControl = new ol.control.ScaleLine({ units: 'metric' });

let map = new ol.Map({
  controls : ol.control.defaults({ zoom: false }).extend([
    zoomControl,
    scaleLineControl
  ]),
  target : 'map' // map을표출할ID
});

//// 중심좌표 127.6, 37.8 (위경도 → Web Mercator)
//let center = ol.proj.fromLonLat([127.6, 37.8]);
//
//// View 설정 (EPSG:3857 기준)
//let mapView = new ol.View({
//  projection: 'EPSG:3857',
//  center: center,
//  zoom: 7
//});
//map.setView(mapView);

// 중심 위경도 좌표 (고정)
const lonLat = [127.6, 37.8];

// EPSG:3857 초기 뷰 설정 (기본값)
const initialView = new ol.View({
  projection: 'EPSG:3857',
  center: ol.proj.fromLonLat(lonLat, 'EPSG:3857'),
  zoom: 7
});
map.setView(initialView);


// EPSG:3857 버튼 클릭 시
document.getElementById('btn-3857').addEventListener('click', () => {
  const newView = new ol.View({
    projection: 'EPSG:3857',
    center: ol.proj.fromLonLat(lonLat, 'EPSG:3857'),
    zoom: 7
  });
  map.setView(newView);
  console.log('현재 프로젝션:', newView.getProjection().getCode());
});

// EPSG:4326 버튼 클릭 시
document.getElementById('btn-4326').addEventListener('click', () => {
  const newView = new ol.View({
    projection: 'EPSG:4326',
    center: lonLat, // EPSG:4326은 위경도 그대로 사용
    zoom: 7
  });
  map.setView(newView);
  console.log('현재 프로젝션:', newView.getProjection().getCode());
});


// OSM 기본 타일 레이어
let baseLayer = new ol.layer.Tile({
  source: new ol.source.OSM()
});
map.addLayer(baseLayer);

////source생성
//let wmsLayer = new ol.layer.Tile({
//  source: new ol.source.TileWMS({
//    url: 'http://119.195.114.103/geoserver/iho/wms',
//    params: {
//      LAYERS: 'iho:worldcountries',
//      TILED: true,
//      SRS: 'EPSG:3857'
//    },
//    serverType: 'geoserver',
//    transition: 0
//  })
//});
//map.addLayer(wmsLayer);


// 도/분/초 변환 함수
function toDMS(deg) {
  const d = Math.floor(deg);
  const minFloat = (deg - d) * 60;
  const m = Math.floor(minFloat);
  const sec = (minFloat - m) * 60;
  return `${d}°${m}'${sec.toFixed(2)}"`;
}

// 좌표 표시 DOM
const coordDiv = document.getElementById('coords');

// 마우스 이동 이벤트
map.on('pointermove', function (evt) {
  const coord = ol.proj.toLonLat(evt.coordinate);
  const lonDMS = toDMS(coord[0]);
  const latDMS = toDMS(coord[1]);
  coordDiv.innerText = `${latDMS}N ${lonDMS}E`;
});

// 스케일 단위 선택 박스 이벤트 연결
const scaleUnitSelect = document.getElementById('scale-unit-select');
scaleUnitSelect.addEventListener('change', (e) => {
  const unit = e.target.value;
  // ScaleLine 컨트롤 단위 변경
  scaleLineControl.setUnits(unit);
});